import {
    useDispatch as useDispatchBase,
    useSelector as useSelectorBase,
    TypedUseSelectorHook,
    useStore as useStoreBase,
  } from 'react-redux'
  import { combineReducers } from 'redux'
  import { configureStore } from '@reduxjs/toolkit'
import userReducer from './user/userSlice'
import stuffReducer from './stuff/stuffSlice'

const reducer = combineReducers({
    user: userReducer,
    stuff: stuffReducer,
})

export const store = configureStore({
    reducer
})

export type TRootState = ReturnType<typeof reducer>
export type TAppDispatch = typeof store.dispatch

export const useDispatch: () => TAppDispatch = useDispatchBase
export const useSelector: TypedUseSelectorHook<TRootState> = useSelectorBase
export const useStore: () => typeof store = useStoreBase
