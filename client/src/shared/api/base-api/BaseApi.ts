import { HTTPTransport } from "../../httptransport/HTTPTransport";

export class BaseApi {
  protected http: HTTPTransport;

  constructor() {
    this.http = new HTTPTransport();
  }

  create() {
    throw new Error("Not implemented");
  }

  request() {
    throw new Error("Not implemented");
  }

  update() {
    throw new Error("Not implemented");
  }

  delete() {
    throw new Error("Not implemented");
  }
}
