import {Injectable} from "@angular/core";
import {Headers, URLSearchParams, Http, Response} from "@angular/http";
import {JsonObject} from "../interfaces/JsonObject";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';
import {SearchParams} from "../interfaces/SearchParams";
/**
 * Created by Daniel on 4/22/2017.
 */

@Injectable()
export class CoursesService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search: URLSearchParams;

  private urlCourses = "/api/courses/";
  private urlSearch = "/api/courses/search?sort=id,asc";
  private urlBooks = "/books";
  private urlProjects = "/projects";
  private urlDocs = "/docs";
  private urlGossips = "/gossips";

  constructor(private http: Http) {
    this.http = http;
  }

  getCourses(searchParamas:SearchParams): Observable<JsonObject> {
    this.setSearch(searchParamas);
    return this.http.get(this.urlCourses,{search:this.search}).map((response: Response) => <JsonObject>response.json());
  }

  getFilteredCourses(searchParamas:SearchParams): Observable<JsonObject> {
    this.setSearch(searchParamas);
    return this.http.get(this.urlSearch,{search:this.search}).map((response: Response) => <JsonObject>response.json());
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


  getCourse(id): Observable<any> {
    return this.http.get(this.urlCourses + id)
      .map((response: Response) => response.json());
  }

  private setSearch(searchParamas:SearchParams):void{
    this.search = new URLSearchParams();
    this.search.set("page",searchParamas.page.toString());
    this.search.set("size",searchParamas.size.toString());
    this.search.set("sort",searchParamas.sort.toString());
    for (let key in searchParamas.search) {
      if (searchParamas.search.hasOwnProperty(key)) {
        let val = searchParamas.search[key];
        this.search.set(key, val);
      }
    }
  }

}
