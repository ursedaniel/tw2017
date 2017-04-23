import { Component, OnInit } from '@angular/core';
import {TabSelected} from "../../../../common/components/tabs/TabSelected";
import {Tab} from "../../../../common/components/tabs/Tab";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'acar-coursedetail',
  templateUrl: './coursedetail.component.html',
  styleUrls: ['./coursedetail.component.css']
})
export class CoursedetailComponent implements OnInit {

  private selectedTab:TabSelected = new TabSelected(1);
  private tabs:Array<Tab> = [
    new Tab(1,"Informatii curs","details",this.courseSelected),
    new Tab(2,"Carti","contacts",this.courseSelected),
    new Tab(3,"Proiecte","projects",this.courseSelected),
    new Tab(4,"Documente","docs",this.courseSelected),
    new Tab(5,"Barfe anonime","gossips",this.courseSelected),
  ];

  private courseSelected:number;

  constructor(private activatedRoute: ActivatedRoute, private _router: Router) {
    let params: any = this.activatedRoute.snapshot.params;
    this.courseSelected=params.id;
  }

  ngOnInit() {
  }

}
