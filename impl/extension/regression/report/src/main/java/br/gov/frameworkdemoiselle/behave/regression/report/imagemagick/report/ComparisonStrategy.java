package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report;

public enum ComparisonStrategy {

    ONE_TO_ONE("One to one direct comparison (Both images of same size)"),
    SUB_IMAGE("Sub image comparison (One image of larger size)"),
    ERROR("Error in image comparison");

    private String value;

    ComparisonStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ComparisonStrategy getStrategyFromDescription(String description) {
        ComparisonStrategy[] strategies = ComparisonStrategy.values();
        ComparisonStrategy matchedStrategy = null;
        for(ComparisonStrategy strategy : strategies)
        {
            if(strategy.getValue().equals(description))
            {
                matchedStrategy = strategy;
                break;
            }
        }
        if(matchedStrategy == null)
        {
             throw new RuntimeException("Matching strategy not found from given description: " + description);
        }
        else
        {
            return matchedStrategy;
        }
    }

    public static ComparisonStrategy getStrategy(String output) {
        if(output.startsWith("compare")) {
            return ERROR;
        } else if(output.contains("@")) {
            return SUB_IMAGE;
        } else {
            return ONE_TO_ONE;
        }
    }
}
