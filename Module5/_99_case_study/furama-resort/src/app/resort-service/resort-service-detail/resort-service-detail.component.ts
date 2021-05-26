import { Component, OnInit } from '@angular/core';
import {IEmployee} from '../../employee/models/IEmployee';
import {IResortService} from '../models/resort-service';
import {ResortServiceService} from '../services/resort-service.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-resort-service-detail',
  templateUrl: './resort-service-detail.component.html',
  styleUrls: ['./resort-service-detail.component.scss']
})
export class ResortServiceDetailComponent implements OnInit {
  service: IResortService;
  serviceId: string;

  constructor(
    private resortServiceService: ResortServiceService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paramMap  => {
      this.serviceId = paramMap.get('id');
      this.resortServiceService.getServiceById(this.serviceId).subscribe((data) => {
        this.service = data;
      });
    });
  }

}
