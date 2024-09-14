import { createAsyncThunk, createSlice, PayloadAction } from "@reduxjs/toolkit";
import UserApi from "../../api/user-api/UserApi";

export interface Stuff {
  id: number
  lastName: string
  name: string
  password: string
  root: boolean
}

export interface StuffState {
    stuff: Stuff[]
    currentStuff: Stuff | null
    loading: boolean
    error: string | null
  }

const initialState: StuffState = {
    stuff: [],
    currentStuff: null,
    loading: false,
    error: null,
  }

export const fetchStuff = createAsyncThunk(
  "stuff/fetchStuff",
  async (_, { rejectWithValue }) => {
    try {
      const result = await UserApi.getUsers()
      return result;
    } catch (error) {
      return rejectWithValue((error as Error).message)
    }
  }
)

export const stuffSlice = createSlice({
    name: 'stuff',
    initialState,
    reducers: {
        addStuffToList: (state, action: PayloadAction<Stuff>) => {
            state.stuff.push(action.payload)
        }
    },
    extraReducers: builder => {
        builder
            .addCase(fetchStuff.pending, state => {
                state.loading = true
                state.error = null
            })
            .addCase(
                fetchStuff.fulfilled,
                (state, action: PayloadAction<Stuff[]>) => {
                    state.loading = false
                    state.stuff = action.payload
                }    
            )
            .addCase(fetchStuff.rejected, (state, action) => {
                state.loading = false
                state.error = action.payload as string
            })
    },
})

export const { addStuffToList } = stuffSlice.actions

export default stuffSlice.reducer
