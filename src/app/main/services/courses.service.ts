import {Injectable} from "@angular/core";
import {Headers, URLSearchParams, Http, Response} from "@angular/http";
import {JsonObject} from "../interfaces/JsonObject";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';
/**
 * Created by Daniel on 4/22/2017.
 */

@Injectable()
export class CoursesService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search: URLSearchParams;

  private urlCourses = "/api/courses/";
  private urlSearch = "/api/courses/search?name=";

  constructor(private http: Http) {
    this.http = http;
  }

  getCourses(): Observable<JsonObject> {
    return this.http.get(this.urlCourses).map((response: Response) => <JsonObject>response.json());
  }

  getFilteredCourses(value): Observable<JsonObject> {
    return this.http.get(this.urlSearch + value).map((response: Response) => <JsonObject>response.json());
  }

  getCourse(id): Observable<any> {
    return this.http.get(this.urlCourses + id)
      .map((response: Response) => response.json());
  }
}