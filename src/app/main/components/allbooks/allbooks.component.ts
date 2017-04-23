import { Component, OnInit } from '@angular/core';
import {Book} from "../../interfaces/Book";

@Component({
  selector: 'acar-allbooks',
  templateUrl: './allbooks.component.html',
  styleUrls: ['./allbooks.component.css']
})
export class AllbooksComponent implements OnInit {

  books: Array<Book> = [
    new Book(1,"Carte 1","Ion creanga","Biblioteca 1"),
    new Book(2,"Carte 2","George Toparceanu","Biblioteca 2"),
    new Book(3,"Carte 3","Mihail Sadoveanu","Biblioteca 3"),
    new Book(4,"Carte 4","Miai Eminescu","Biblioteca 4"),
    new Book(5,"Carte 5","I.L. Caragiale","Biblioteca 5"),
    new Book(6,"Carte 6","Lucian Blaga","Biblioteca 6"),
    new Book(7,"Carte 7","Vasile Lupu","Biblioteca 7"),
    new Book(8,"Carte 8","Nechita stanescu","Biblioteca 8"),
    new Book(9,"Carte 9","Ion creanga","Biblioteca 9"),
    new Book(10,"Carte 10","Ion creanga","Biblioteca 10"),
    new Book(6,"Carte 11","Lucian Blaga","Biblioteca 11"),
    new Book(7,"Carte 12","Vasile Lupu","Biblioteca 12"),
    new Book(8,"Carte 13","Nechita stanescu","Biblioteca 13"),
    new Book(9,"Carte 14","Ion creanga","Biblioteca 14"),
    new Book(10,"Carte 15","Ion creanga","Biblioteca 15")
  ];


  constructor() { }

  ngOnInit() {
  }

}
