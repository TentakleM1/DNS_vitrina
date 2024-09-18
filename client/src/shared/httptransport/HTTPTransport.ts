import { IUser } from "shared/store/user/userSlice";
import { BASE_URL } from "../constant";
import { METHODS } from "./type";

interface IOptions {
    data?: IUser | null
}

export class HTTPTransport {
    static BASE_URL: string = BASE_URL

    public get(url: string, options: IOptions = {}) {
        return this.request(METHODS.GET, url, options)
    }

    public post(url: string, options: IOptions = {}) {
        return this.request(METHODS.POST, url, options)
    }

    public put(url: string, options: IOptions = {}) {
        return this.request(METHODS.PUT, url, options)
    }

    public delete (url: string) {
        return this.request(METHODS.DELETE, url)
    }

    private  async request(method: string, url: string, options: IOptions = {}) {
        const { data } = options
        if(method === METHODS.GET) {
            const response = await fetch(`${BASE_URL}${url}`)

            if(!response.ok) {
                throw new Error(`GET request error`)
            }
            return await response.json()

        }

        const response = await fetch(`${BASE_URL}${url}`, {
            method: method,
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        })
        
        if(!response.ok) {
            throw new Error(`${method} request error`)
        }

        return await response.json()

    }
}
