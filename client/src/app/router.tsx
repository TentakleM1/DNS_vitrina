import { createBrowserRouter } from "react-router-dom";
import {Login, Map} from "../pages";

export const routers = createBrowserRouter([
    {
        path: "/",
        element: <Login /> ,
    },
    {
      path: '/map',
      element: <Map />
    }
])
