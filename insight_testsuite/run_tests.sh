javac -d ./  .././src/Drugs.java
java Drugs ./tests/test_1/input/itcont.txt ./tests/test_1/output/top_cost_drug.txt
now=$(date)
if [ ! -z "$(diff ./tests/test_1/output/top_cost_drug.txt ./tests/test_1/output/expected_top_cost_drug.txt)" ]; then
	echo [FAIL]: test_1
	echo "[$now]  0 of 1 tests passed"
else
	echo "[PASS]: test_1"
	echo "[$now] 1 of 1 tests passed"
fi


java Drugs ./tests/test_2/input/itcont.txt ./tests/test_2/output/top_cost_drug.txt


if [ ! -z "$(diff ./tests/test_2/output/top_cost_drug.txt ./tests/test_2/output/expected_top_cost_drug.txt)" ]; then
	echo "[FAIL]: test_2"
	echo "[$now] 0 of 1 tests passed"
else
	echo "[PASS]: test_2"
	echo "[$now] 1 of 1 tests passed"
fi


