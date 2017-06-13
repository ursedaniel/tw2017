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
export class TeachersService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search: URLSearchParams;

  private urlTeacher = "/api/teachers/";
  private urlSearch = "/api/teachers/search?sort=id,asc";
  private urlRating = "/ranking";

  constructor(private http: Http) {
    this.http = http;
  }

  getTeachers(searchParamas:SearchParams): Observable<JsonObject> {
    this.setSearch(searchParamas);
    return this.http.get(this.urlTeacher,{search: this.search}).map((response: Response) => <JsonObject>response.json());
  }

  getFilteredTeachers(searchParamas:SearchParams): Observable<JsonObject> {
    this.setSearch(searchParamas);
    return this.http.get(this.urlSearch,{search: this.search}).map((response: Response) => <JsonObject>response.json());
  }

  getTeacher(id): Observable<any> {
    return this.http.get(this.urlTeacher + id)
      .map((response: Response) => response.json());
  }

  addTeacher(teacherId,postObject) : Observable<any> {
    return this.http.post(this.urlTeacher + teacherId + this.urlRating,JSON.stringify(postObject),  new RequestOptions({headers: this.headers}))
      .map((response: Response) => response);
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
