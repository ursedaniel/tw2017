import {Injectable} from "@angular/core";
import {Headers, URLSearchParams, Http, Response, RequestOptions} from "@angular/http";
import {JsonObject} from "../interfaces/JsonObject";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';
import {SearchParams} from "../interfaces/SearchParams";
/**
 * Created by Daniel on 4/22/2017.
 */

@Injectable()
export class UsersService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search: URLSearchParams;

  private urlLogin = "/api/login/";

  constructor(private http: Http) {
    this.http = http;
  }

  login(postObject) : Observable<any> {
    return this.http.post(this.urlLogin,JSON.stringify(postObject),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => response);
  }
}
