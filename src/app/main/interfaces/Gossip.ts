/**
 * Created by Daniel on 4/24/2017.
 */
export class Gossip {
  public id: number;
  public title: string;
  public date: string;
  public content: string;

  constructor(id,title,date,content) {
    this.id = id;
    this.title = title;
    this.date = date;
    this.content = content;
  }
}
