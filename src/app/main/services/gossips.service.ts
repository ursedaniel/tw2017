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
export class GossipsService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private search: URLSearchParams;

  private urlSearch = "/api/gossips/search?sort=id,asc";
  private urlGossips = "/api/gossips";

  constructor(private http: Http) {
    this.http = http;
  }

  getGossips(searchParamas:SearchParams): Observable<JsonObject> {
    this.setSearch(searchParamas);
    return this.http.get(this.urlGossips,{search:this.search}).map((response: Response) => <JsonObject>response.json());
  }

  getFilteredGossips(searchParamas:SearchParams): Observable<JsonObject> {
    this.setSearch(searchParamas);
    return this.http.get(this.urlSearch,{search:this.search}).map((response: Response) => <JsonObject>response.json());
  }

  addGossip(postObject) : Observable<any> {
    return this.http.post(this.urlGossips,JSON.stringify(postObject),  new RequestOptions({headers: this.headers}))
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
