### Build
```bash
./gradlew clean spotlessApply build 
```

### Run
Where the `calculator_subtract_feature` is an example system property feature flag, accepts boolean string

disabled
```bash
java -jar -Dcalculator_subtract_feature=false main-module/build/libs/main-module-1.0-SNAPSHOT.jar
```
enabled
```bash
java -jar -Dcalculator_subtract_feature=true main-module/build/libs/main-module-1.0-SNAPSHOT.jar
```