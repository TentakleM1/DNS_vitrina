import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    user: {
        id: 0,
        lastName: 'Trynyt',
        name: 'Dima',
        password: '123456',
        root: false    
    }
}

const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {
        setUser(state, action) {
            state.user = action.payload
        }
    }
})

export const {
    setUser
} = userSlice.actions

export default userSlice.reducer
