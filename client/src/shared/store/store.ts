import { combineReducers, configureStore, createSlice } from "@reduxjs/toolkit";

const initialState = {
    user: {
        name: 'Dima',
        lastName: 'Trynyt'
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

const userReducer = userSlice.reducer

const reducer = combineReducers({
    user: userReducer
})

export const store = configureStore({
    reducer
})
