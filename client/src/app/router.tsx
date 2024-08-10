import { createBrowserRouter } from "react-router-dom";
import {Login, Map, Reg} from "../pages";

export const routers = createBrowserRouter([
    {
        path: "/",
        element: <Login /> ,
    },
    {
        path: "/sign-up",
        element: <Reg />
    },
    {
        path: "/map",
        element: <Map />
    }
])
