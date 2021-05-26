import {ICustomer} from '../../customer/models/customer';
import {IEmployee} from '../../employee/models/IEmployee';
import {IResortService} from '../../resort-service/models/resort-service';
import {IContractDetail} from './contract-detail';
import {IStayPeriod} from './stay-period';

export interface IContract {
  id: number;
  customer: ICustomer;
  employee: IEmployee;
  service: IResortService;
  contract_detail: IContractDetail[];
  stay_period: IStayPeriod;
  amount: number;
}
