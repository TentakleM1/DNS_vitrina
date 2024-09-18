import { IUser } from "shared/store/user/userSlice";
import { BaseApi } from "../base-api/BaseApi";
import { IStuff } from "shared/store/stuff/stuffSlice";
class UserApi extends BaseApi {
    constructor() {
        super()
    }

    public login(data: IUser) {
        return this.http.post('/sign-in', {data: data})
    }

    public getUsers() {
        return this.http.get('/users')
    }

    public  createUser(data: IStuff) {
        return this.http.post('/user', { data: data })
    }
}

export default new UserApi()
