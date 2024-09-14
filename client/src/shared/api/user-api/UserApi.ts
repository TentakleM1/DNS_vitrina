import { BaseApi } from "../base-api/BaseApi";

class UserApi extends BaseApi {
    constructor() {
        super()
    }

    public getUsers() {
        return this.http.get({ url: '/users' })
    }
}

export default new UserApi()
