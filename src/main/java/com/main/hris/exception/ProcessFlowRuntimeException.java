package com.main.hris.exception;

public class ProcessFlowRuntimeException extends ABaseException {
    private static final long serialVersionUID = 7967391958852846420L;

    public static final String VALUE_NOT_INSTANCE_OF_EMAIL_DTO = "Value is not instanceof EmailDto";
    public static final String FILE_TRANSFER_UPLOAD_FILE_NAME_MANDATORY = "File name is mandatory";
    public static final String VALUE_NOT_INSTANCE_OF_CHART_REQUEST_DTO = "Value is not instanceof ChartRequestDto";
    public static final String CANNOT_ADD_DATA_WITH_AN_INAPPRORIATE_CLASS = "Data property must be one of TimeSeriesDayRequestDto, TimeSeriesMonthRequestDto, TimeSeriesWeekRequestDto and TimeSeriesYearRequestDto class";
    public static final String CANNOT_ADD_DIFFERENT_TIME_SERIES_DATA_CLASS = "Class type of data property cannot be different";



    public ProcessFlowRuntimeException(String message, Object... arguments) {
        super(message, arguments);
    }

    public ProcessFlowRuntimeException(String message, Throwable cause, Object... arguments) {
        super(message, cause, arguments);
    }
}
