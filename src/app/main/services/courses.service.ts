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

  private urlCourse = "/api/courses/";

  constructor(private http: Http) {
    this.http = http;
  }

  getCourses(): Observable<JsonObject> {
    return this.http.get(this.urlCourse).map((response: Response) => <JsonObject>response.json());
  }
}
