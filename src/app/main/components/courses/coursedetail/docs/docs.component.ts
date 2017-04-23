import {Component, OnInit, Input} from '@angular/core';
import {Doc} from "../../../../interfaces/Doc";

@Component({
  selector: 'acar-docs',
  templateUrl: './docs.component.html',
  styleUrls: ['./docs.component.css']
})
export class DocsComponent implements OnInit {

  docs: Array<Doc> = [
    new Doc(1,"Document 1","www.document1.ro"),
    new Doc(2,"Document 2","www.document2.ro"),
    new Doc(3,"Document 3","www.document3.ro"),
    new Doc(4,"Document 4","www.document4.ro"),
    new Doc(5,"Document 5","www.document5.ro")
  ];

  @Input() courseId: any;


  constructor() { }

  ngOnInit() {
  }

}
