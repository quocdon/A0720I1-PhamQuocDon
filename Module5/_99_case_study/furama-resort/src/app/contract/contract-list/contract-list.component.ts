import { Component, OnInit } from '@angular/core';
import {IContract} from '../models/contract';
import {ContractService} from '../services/contract.service';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.scss']
})
export class ContractListComponent implements OnInit {
  contracts: IContract[];

  constructor(private contractService: ContractService) { }

  ngOnInit(): void {
    this.contractService.getAllContracts().subscribe(data => {
      this.contracts = data;
    });
  }

  doSearch(search: HTMLInputElement) {
  }
}
