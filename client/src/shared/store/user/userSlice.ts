import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import UserApi from "../../api/user-api/UserApi";

const initialState = {
    user: {
        id: 0,
        lastName: '',
        name: '',
        password: '',
        root: false    
    }
}

export interface IUser {
    lastName: string,
    password: string
}

export const loginUser = createAsyncThunk(
    'login/fetchLogin',
    async (
        login: IUser,
        { rejectWithValue, dispatch }
    ) => {
        try {
            const user = await UserApi.login(login)
            dispatch(addUser(user))
        } catch (error) {
            return rejectWithValue((error as Error).message)
        }
    }
)

const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {
        addUser(state, action) {
            state.user = action.payload
        }
    }
})

export const {
    addUser
} = userSlice.actions

export default userSlice.reducer
