import { createSlice } from "@reduxjs/toolkit";

interface  User {
    id: number,
    name: string,
    password: string,
    lastName: string,
    root: boolean,  
}

export interface UsersState {
    data: User | null
    isLoading: boolean
}

const initialState: UsersState = {
    data: null,
    isLoading: false,
}

export const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {},
})
