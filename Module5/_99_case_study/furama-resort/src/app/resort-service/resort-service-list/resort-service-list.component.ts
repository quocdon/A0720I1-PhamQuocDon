import { Component, OnInit } from '@angular/core';
import {ResortServiceService} from '../services/resort-service.service';
import {IResortService} from '../models/resort-service';

@Component({
  selector: 'app-resort-service-list',
  templateUrl: './resort-service-list.component.html',
  styleUrls: ['./resort-service-list.component.scss']
})
export class ResortServiceListComponent implements OnInit {
  resortServices: IResortService[];
  page = 1;
  limit = 5;
  nextPage: IResortService[] = [];
  isSearch = false;
  selectedService: IResortService = {
    area: 0,
    id: 0,
    max_people: 0,
    name: '',
    price: 0,
    rent_type: '',
    service_id: ''
  };
  constructor(private resortServiceService: ResortServiceService) { }

  ngOnInit(): void {
    this.isSearch = false;
    this.resortServiceService.getServicesPagination(this.page, this.limit).subscribe(data => {
      this.resortServices = data;
    });
    this.resortServiceService.getServicesPagination(this.page + 1, this.limit).subscribe(data => {
      this.nextPage = data;
    });
  }

  doSearch(search) {
    this.isSearch = true;
    const searchValue = search.value.trim();
    if (searchValue !== '') {
      this.resortServiceService.search(searchValue).subscribe(data => {
        this.resortServices = data;
      });
    } else {
      this.ngOnInit();
    }
  }

  deleteService(id) {
    this.resortServiceService.getServiceById(id).subscribe(data => {
      if (confirm('Bạn muốn xóa dịch vụ ' + data.name + ' không?')){
        this.resortServiceService.deleteService(id).subscribe(deletedData => {
          alert('Xóa thành công dịch vụ ' + data.name);
          this.ngOnInit();
        });
      }
    });
  }

  previous() {
    this.page--;
    this.ngOnInit();
  }

  next() {
    this.page++;
    this.ngOnInit();
  }

  selectService(resortService: IResortService) {
    this.selectedService = resortService;
  }
}
