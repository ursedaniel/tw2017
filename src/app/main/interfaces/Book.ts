/**
 * Created by Daniel on 4/23/2017.
 */
export class Book {
  id: number;
  title: string;
  author: string;
  location: string;

  constructor(id, title, author, location) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.location = location;
  }
}
