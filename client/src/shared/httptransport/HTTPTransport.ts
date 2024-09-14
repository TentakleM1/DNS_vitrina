import { BASE_URL } from "../constant";
import { METHODS } from "./type";

interface Options {
    url: string
    data?: Record<string, string> | null
}

export class HTTPTransport {
    static BASE_URL: string = BASE_URL

    public get(options: Options) {
        return this.request(METHODS.GET, options)
    }

    public post() {

    }

    public put() {

    }

    public delete () {

    }

    private  async request(method: string, options: Options) {
        const { url, data } = options
        if(method === METHODS.GET) {
            const response = await fetch(`${BASE_URL}${url}`)

            if(!response.ok) {
                throw new Error(`GET request error`)
            }
            return await response.json()

        }

        const response = await fetch(`${BASE_URL}${url}`, {
            method: method,
            credentials: 'include',
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
