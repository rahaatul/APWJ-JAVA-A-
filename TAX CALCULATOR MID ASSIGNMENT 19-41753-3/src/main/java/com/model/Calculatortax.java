package com.model;



public class Calculatortax {
    public void SalaryCall()
    {
        double bsal = 0;
        double tax,allo,nsal;



        if(bsal < 300000)
        {
            tax = 0.0;
            allo =  bsal ;
        }

        else if(bsal >= 300000)
        {
            tax = bsal * 0.1;
            allo =  bsal * 0.15;
        }
        else if(bsal >= 400000)
        {
            tax = bsal * 0.15;
            allo =  bsal * 0.1;
        }
        else if(bsal >= 500000)
        {
            tax = bsal * 0.20;
            allo =  bsal * 0.5;
        }

        else if(bsal > 600000)
        {
            tax = bsal * 0.25;
            allo =  bsal * 0.5;
        }
        else
        {
            tax = 0.0;
            allo =  0.0;
        }
        nsal = bsal + allo - tax;
       String.valueOf(tax);
       String.valueOf(allo);
       String.valueOf(nsal);

    }


    }







