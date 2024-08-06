import { createBrowserRouter } from "react-router-dom";
import { Login, Reg } from "../pages";
import { Map } from "../pages/map";

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
