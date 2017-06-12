import {Component, OnInit, ViewChild} from '@angular/core';
import {Doc} from "../../interfaces/Doc";
import {PagerObject} from "../../interfaces/PagerObject";
import {SearchParams} from "../../interfaces/SearchParams";
import {Observable} from "rxjs";
import {DocsService} from "../../services/docs.service";

@Component({
  selector: 'acar-alldocuments',
  templateUrl: './alldocuments.component.html',
  styleUrls: ['./alldocuments.component.css']
})
export class AlldocumentsComponent implements OnInit {

  docs: any;
  @ViewChild('nameFilter') filterInput: any;
  private filterObs: any;
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();
  private searchObject: Doc = new Doc();

  constructor(private docsService: DocsService) { }

  ngOnInit() {
    this.getDocs();
    this.filterObs = Observable.fromEvent(this.filterInput.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInput.nativeElement.value)
      .subscribe((value) => {
        this.searchObject.title = value;
        this.searchParamas.search = this.searchObject;
        this.getDocsFiltered();
      });
  }

  getDocs() {
    this.docsService.getDocs(this.searchParamas).subscribe(
      (response) => {
        this.docs = response.content;
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    );
  }

  getDocsFiltered() {
    this.docsService.getFilteredDocs(this.searchParamas).subscribe(
      (response) => {
        this.docs = response.content;
      }
    );
  }

  handlePageChanged(data) {
    this.searchParamas.page = this.pager.page;
    this.searchParamas.size = this.pager.rows;
    this.getDocs();
  }
}
