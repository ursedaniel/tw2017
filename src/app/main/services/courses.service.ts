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
  private urlBooks = "/books";
  private urlProjects = "/projects";
  private urlDocs = "/docs";
  private urlGossips = "/gossips";

  constructor(private http: Http) {
    this.http = http;
  }

  getCourses(): Observable<JsonObject> {
    return this.http.get(this.urlCourses).map((response: Response) => <JsonObject>response.json());
  }

  getBooks(courseId): Observable<JsonObject> {
    return this.http.get(this.urlCourses + courseId + this.urlBooks).map((response: Response) => <JsonObject>response.json());
  }

  getGossips(courseId): Observable<JsonObject> {
    return this.http.get(this.urlCourses + courseId + this.urlGossips).map((response: Response) => <JsonObject>response.json());
  }

  getDocs(courseId): Observable<JsonObject> {
    return this.http.get(this.urlCourses + courseId + this.urlDocs).map((response: Response) => <JsonObject>response.json());
  }

  getProjects(courseId): Observable<JsonObject> {
    return this.http.get(this.urlCourses + courseId + this.urlProjects).map((response: Response) => <JsonObject>response.json());
  }


  getFilteredCourses(value): Observable<JsonObject> {
    return this.http.get(this.urlSearch + value).map((response: Response) => <JsonObject>response.json());
  }

  getCourse(id): Observable<any> {
    return this.http.get(this.urlCourses + id)
      .map((response: Response) => response.json());
  }
}
