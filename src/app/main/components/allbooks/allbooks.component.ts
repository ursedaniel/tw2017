import {Component, OnInit, ViewChild} from '@angular/core';
import {Book} from "../../interfaces/Book";
import {Observable} from "rxjs";
import {BooksService} from "../../services/books.service";
import {SearchParams} from "../../interfaces/SearchParams";
import {PagerObject} from "../../interfaces/PagerObject";

@Component({
  selector: 'acar-allbooks',
  templateUrl: './allbooks.component.html',
  styleUrls: ['./allbooks.component.css']
})
export class AllbooksComponent implements OnInit {

  books: any;
  @ViewChild('titleFilter') filterInput: any;
  private filterObs: any;
  @ViewChild('authorFilter') filterInputAuthor: any;
  private filterObsAuthor: any;
  @ViewChild('locationFilter') filterInputLocation: any;
  private filterObsLocation: any;
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();
  private searchObject: Book = new Book();

  constructor(private booksService: BooksService) { }

  ngOnInit() {
    this.getBooks();
    this.filterObs = Observable.fromEvent(this.filterInput.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInput.nativeElement.value)
      .subscribe((value) => {
        this.searchObject.title = value;
        this.searchParamas.search = this.searchObject;
        this.getBooksFiltered();
      });
    this.filterObsAuthor = Observable.fromEvent(this.filterInputAuthor.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInputAuthor.nativeElement.value)
      .subscribe((value) => {
        this.searchObject.author = value;
        this.searchParamas.search = this.searchObject;
        this.getBooksFiltered();
      });
    this.filterObsLocation = Observable.fromEvent(this.filterInputLocation.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInputLocation.nativeElement.value)
      .subscribe((value) => {
        this.searchObject.location = value;
        this.searchParamas.search = this.searchObject;
        this.getBooksFiltered();
      });
  }

  getBooks() {
    this.booksService.getBooks(this.searchParamas).subscribe(
      (response) => {
        this.books = response.content;
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    );
  }

  getBooksFiltered() {
    this.booksService.getFilteredBooks(this.searchParamas).subscribe(
      (response) => {
        this.books = response.content;
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    );
  }

  handlePageChanged(data) {
    this.searchParamas.page = this.pager.page;
    this.searchParamas.size = this.pager.rows;
    this.getBooks();
  }

}
