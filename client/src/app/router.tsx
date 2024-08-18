import { createBrowserRouter } from "react-router-dom";
import { Login, Reg } from "../pages";

export const routers = createBrowserRouter([
    {
        path: "/",
        element: <Login /> ,
    },
    {
        path: "/sign-up",
        element: <Reg />
    }

])
