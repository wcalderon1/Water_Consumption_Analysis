# Water Consumption & Cost Analysis

**Tools:** Hadoop 3.x, Java, MapReduce, HDFS
**Dataset:** NYC Department of Environmental Protection — Water Consumption & Cost (60,000+ billing records)
**Course:** ITEC 4310 — Georgia Gwinnett College, Spring 2025

---

## Project Overview

How much does water cost across New York City's diverse neighborhoods — and what drives those costs? This project analyzes over 60,000 NYC water billing records using a distributed Hadoop MapReduce pipeline to uncover cost variability trends across boroughs, building types, and billing periods.

By processing raw billing data through custom Java MapReduce jobs, the analysis surfaces patterns in consumption rates and costs that would be impractical to explore with single-machine tools.

---

## Architecture

The pipeline follows a standard MapReduce pattern:

| Component | File | Purpose |
|---|---|---|
| Driver | `WaterAnalysisDriver.java` | Configures and launches the MapReduce job |
| Mapper | `WaterConsumptionMapper.java` | Parses billing records and emits key-value pairs |
| Reducer | `WaterCostReducer.java` | Aggregates and computes cost statistics per group |
| Output | `part-00000` | Final MapReduce output |

---

## Datasets

| File | Description |
|---|---|
| `nyc_water_data.csv` | Raw NYC water billing dataset |
| `consumption_costs.csv` | Consumption and cost data extracted for analysis |
| `cleaned_consumption_costs.csv` | Cleaned version with standardized columns |

---

## Key Findings

- Significant cost variability exists across different building service classifications
- - Consumption rates vary substantially by borough and billing period
  - - The MapReduce aggregation reveals patterns not visible in raw record-by-record inspection
    - - Large outliers in per-unit cost suggest billing anomalies worth further investigation
     
      - ---

      ## How to Run

      1. Ensure Hadoop is installed and configured
      2. 2. Compile the Java source files or use the pre-built `WaterConsumptionAnalysis.jar`
         3. 3. Upload the dataset to HDFS:
            4.    ```bash
                     hdfs dfs -put nyc_water_data.csv /input/
                     ```
                  4. Run the job:
                  5.    ```bash
                           hadoop jar WaterConsumptionAnalysis.jar WaterAnalysisDriver /input/nyc_water_data.csv /output/
                           ```
                        5. View results:
                        6.    ```bash
                                 hdfs dfs -cat /output/part-00000
                                 ```

                              ---

                          ## Files

                    ```
                    Water_Consumption_Analysis/
                    ├── README.md
                    ├── WaterAnalysisDriver.java       <- Job configuration & entry point
                    ├── WaterConsumptionMapper.java    <- Map phase logic
                    ├── WaterCostReducer.java          <- Reduce phase logic
                    ├── WaterConsumptionAnalysis.jar   <- Compiled JAR
                    ├── nyc_water_data.csv             <- Raw dataset
                    ├── consumption_costs.csv          <- Extracted cost data
                    ├── cleaned_consumption_costs.csv  <- Cleaned dataset
                    ├── part-00000                     <- MapReduce output
                    └── HW2_Report.docx                <- Full written analysis report
                    ```

                    ---

              *Individual project — Wendy Calderon · Georgia Gwinnett College · Spring 2025*
