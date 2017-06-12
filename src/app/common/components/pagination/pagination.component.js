"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require('@angular/core');
var PaginationComponent = (function () {
    function PaginationComponent() {
        this.pageChanged = new core_1.EventEmitter();
    }
    PaginationComponent.prototype.ngOnInit = function () {
    };
    PaginationComponent.prototype.jump = function (limit) {
        this.pager.limit = limit;
        this.pageChanged.emit();
    };
    PaginationComponent.prototype.changeRows = function (rows) {
        this.pager.rows = rows;
        this.pager.limit = 0;
        this.pageChanged.emit();
    };
    __decorate([
        core_1.Output()
    ], PaginationComponent.prototype, "pageChanged", void 0);
    __decorate([
        core_1.Input()
    ], PaginationComponent.prototype, "pager", void 0);
    __decorate([
        core_1.Input()
    ], PaginationComponent.prototype, "postObject", void 0);
    PaginationComponent = __decorate([
        core_1.Component({
            selector: 'lp-pagination',
            templateUrl: './pagination.component.html',
            styleUrls: ['./pagination.component.css']
        })
    ], PaginationComponent);
    return PaginationComponent;
}());
exports.PaginationComponent = PaginationComponent;
