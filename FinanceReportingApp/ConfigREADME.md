##WARNING: Please refrain from editing the configuration file manually as it may break the program

### Configuration File

The configuration file ***config.properties*** is the location of most of the settings for this program. See below for what each of the configuration keys mean.

- `lastModified`: An automated date of the last modification to the configuration file. **Do not change**


- `contractsFileNamesMonthEnd`: The name(s) of the contract file(s) being provided (if using CSV as primary data input method)
    - **MUST** include this field if using CSV files as primary input method
    - Separate each file name with a comma ',' if using more than one input file
    - Do not use spaces in the file name
    - Include the file identifier on the end (.csv)
    
    
- `transactionFileNamesMonthEnd`: The name(s) of the transaction file(s) being provided
    - **MUST** include this field if using CSV files as primary input method
    - Separate each file name with a comma ',' if using more than one input file
    - Do not use spaces in the file name
    - Include the file identifier on the end (.csv)
    
    
- `defInputDirectory`: The default directory of the contract and transaction input files
    - **MUST** include this field if using CSV files as primary input method
    - There may only be one input directory
    
    
- `defOutputDirectory`: The default directory of the output files (where the reports are written once the program has finished
    - **MUST** include this field if using CSV files as primary input method
    - There may only be one output directory