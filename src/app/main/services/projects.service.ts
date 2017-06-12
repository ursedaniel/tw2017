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
export class ProjectsService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search: URLSearchParams;

  private urlSearch = "/api/projects/search?sort=id,asc";
  private urlProjects = "/api/projects";

  constructor(private http: Http) {
    this.http = http;
  }

  getProjects(searchParamas:SearchParams): Observable<JsonObject> {
    this.setSearch(searchParamas);
    return this.http.get(this.urlProjects,{search:this.search}).map((response: Response) => <JsonObject>response.json());
  }

  getFilteredProjects(searchParamas:SearchParams): Observable<JsonObject> {
    this.setSearch(searchParamas);
    return this.http.get(this.urlSearch,{search:this.search}).map((response: Response) => <JsonObject>response.json());
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
