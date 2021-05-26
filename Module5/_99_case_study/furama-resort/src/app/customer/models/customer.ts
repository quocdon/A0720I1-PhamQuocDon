import {ICustomerType} from './customer-type';

export interface ICustomer {
  id: number;
  cus_id: string;
  name: string;
  birthday: string;
  gender: string;
  id_card: string;
  phone: string;
  email: string;
  cus_type: ICustomerType;
  address: string;
}
