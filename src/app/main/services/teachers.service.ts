import {Injectable} from "@angular/core";
import {Headers, URLSearchParams, Http, Response} from "@angular/http";
import {JsonObject} from "../interfaces/JsonObject";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';
/**
 * Created by Daniel on 4/22/2017.
 */

@Injectable()
export class TeachersService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search: URLSearchParams;

  private urlTeacher = "/api/teachers/";
  private urlSearch = "/api/teachers/search?name=";

  constructor(private http: Http) {
    this.http = http;
  }

  getTeachers(): Observable<JsonObject> {
    return this.http.get(this.urlTeacher).map((response: Response) => <JsonObject>response.json());
  }

  getFilteredTeachers(value): Observable<JsonObject> {
    return this.http.get(this.urlSearch + value).map((response: Response) => <JsonObject>response.json());
  }

  getTeacher(id): Observable<any> {
    return this.http.get(this.urlTeacher + id)
      .map((response: Response) => response.json());
  }
}
