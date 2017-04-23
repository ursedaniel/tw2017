import { Component, OnInit } from '@angular/core';
import {TabSelected} from "../../../../common/components/tabs/TabSelected";
import {Tab} from "../../../../common/components/tabs/Tab";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'acar-teacherdetail',
  templateUrl: './teacherdetail.component.html',
  styleUrls: ['./teacherdetail.component.css']
})
export class TeacherdetailComponent implements OnInit {

  private selectedTab:TabSelected = new TabSelected(1);
  private tabs:Array<Tab> = [
    new Tab(1,"Informatii profesor","details",this.teacherSelected),
    new Tab(2,"Barfe anonime","contacts",this.teacherSelected),
    new Tab(3,"Orar","projects",this.teacherSelected)
  ];

  private teacherSelected:number;

  constructor(private activatedRoute: ActivatedRoute, private _router: Router) {
    let params: any = this.activatedRoute.snapshot.params;
    this.teacherSelected=params.id;
  }

  ngOnInit() {}

}
