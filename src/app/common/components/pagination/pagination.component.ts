import {Component, OnInit, Input, EventEmitter, Output} from '@angular/core';
import {PagerObject} from "../../../main/interfaces/PagerObject";

@Component({
  selector: 'lp-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent implements OnInit{

  @Output() pageChanged = new EventEmitter();
  @Input() public pager:PagerObject;
  constructor() {

  }

  ngOnInit() {
  }

  jump(page){
    this.pager.page=page;
    this.pageChanged.emit();
  }
  changeRows(rows){
    this.pager.rows=rows;
    this.pager.page=0;
    this.pageChanged.emit();
  }

}
