import { Component, OnInit } from '@angular/core';
import {Doc} from "../../interfaces/Doc";

@Component({
  selector: 'acar-alldocuments',
  templateUrl: './alldocuments.component.html',
  styleUrls: ['./alldocuments.component.css']
})
export class AlldocumentsComponent implements OnInit {

  docs: Array<Doc> = [
    new Doc(1,"Document 1","www.document1.ro"),
    new Doc(2,"Document 2","www.document2.ro"),
    new Doc(3,"Document 3","www.document3.ro"),
    new Doc(4,"Document 4","www.document4.ro"),
    new Doc(5,"Document 5","www.document5.ro"),
    new Doc(8,"Document 8","www.document8.ro"),
    new Doc(12,"Document 12","www.document12.ro"),
    new Doc(17,"Document 17","www.document17.ro"),
    new Doc(24,"Document 24","www.document24.ro"),
    new Doc(35,"Document 35","www.document35.ro"),
    new Doc(44,"Document 4","www.document44.ro"),
    new Doc(55,"Document 5","www.document55.ro"),
    new Doc(68,"Document 8","www.document88.ro"),
    new Doc(112,"Document 12","www.document112.ro"),
    new Doc(117,"Document 17","www.document117.ro"),
    new Doc(224,"Document 24","www.document224.ro"),
    new Doc(335,"Document 35","www.document335.ro")
  ];

  constructor() { }

  ngOnInit() {
  }

}
