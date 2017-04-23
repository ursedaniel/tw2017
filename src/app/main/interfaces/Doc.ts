/**
 * Created by Daniel on 4/23/2017.
 */
export class Doc {
  id: number;
  title: string;
  link: string;

  constructor(id, title, link) {
    this.id = id;
    this.title = title;
    this.link = link;
  }
}
