import { IUser } from "shared/store/user/userSlice";
import { BaseApi } from "../base-api/BaseApi";
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
}

export default new UserApi()
