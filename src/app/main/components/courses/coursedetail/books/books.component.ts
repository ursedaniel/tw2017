import {Component, OnInit, Input} from '@angular/core';
import {Book} from "../../../../interfaces/Book";

@Component({
  selector: 'acar-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Array<Book> = [
    new Book(1,"Carte 1","Ion creanga","Biblioteca V.A Urechia"),
    new Book(2,"Carte 2","Ion creanga","Biblioteca V.A Urechia"),
    new Book(3,"Carte 3","Ion creanga","Biblioteca V.A Urechia"),
    new Book(4,"Carte 4","Ion creanga","Biblioteca V.A Urechia"),
    new Book(5,"Carte 5","Ion creanga","Biblioteca V.A Urechia")
  ];


  @Input() courseId: any;

  constructor() { }

  ngOnInit() {
  }

}
