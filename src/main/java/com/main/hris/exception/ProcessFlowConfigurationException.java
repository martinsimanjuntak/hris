package com.main.hris.exception;

public class ProcessFlowConfigurationException extends ABaseException {
    private static final long serialVersionUID = -5846503831467584835L;

    public static final String REPOSITORY_NODE_TYPE_ERROR = "Repository Node Type is missing";
    public static final String DTO_CONSTRUCTION_NODE_TYPE_ERROR = "Dto Construction Node Type is missing";
    public static final String CONFIGURATION_NOT_EXIST_ERROR = "No Process Flow Configuration Available";
    public static final String DUPLICATE_NODE_ID_ERROR = "Node id (''{0}'') must be unique";
    public static final String NESTED_NODE_CANNOT_BE_EMPTY = "{1} node (''{0}'') must have at least 1 sub node";
    public static final String CONDITION_NODE_CANNOT_BE_EMPTY = "Condition node (''{0}'') must have at least 1 sub node";
    public static final String INPUT_NODE_INVALID_ERROR = "Invalid Input Node";
    public static final String INPUT_FIELD_NAME_SHOULD_EXTENDS_CLASS_ERR = "Input Field Name Should be extend from class (''{0}'')";
    public static final String INPUT_FIELD_NAME_AND_FUNCTION_SAVE_FILE_CANNOT_NULL = "Input Field Name and Construct Save File Function Cannot null";
    public static final String ENTITY_MASTER_MANDATORY_ERROR = "Master Entity Cannot Null";
    public static final String ENTITY_DETAIL_MANDATORY_ERROR = "Detail Entity Cannot Null";
    public static final String FILE_MANDATORY_ERROR = "File Cannot Null";
    public static final String FILE_MULTIPART_FILE_TYPE_ERROR = "File Must be Multipart File";
    public static final String PARSE_FILE_TYPE_ERROR = "Parse File Node Type is missing";
    public static final String PARSE_FILE_RESPONSE_CLASS_MANDATORY_ERROR = "Parse File Response Class Cannot Null";
    public static final String PARSE_FILE_FORMAT_MANDATORY_ERROR = "Parse File Format Cannot Null or Empty";
    public static final String GENERATE_OTP_INVALID_REQUEST = "Input field must be instance of OtpRequestDto";
    public static final String VERIFY_OTP_INVALID_REQUEST = "Input field must be instance of OtpVerifyDto";
    public static final String DECRYPT_PGP_INVALID_REQUEST = "Input field must be instance of PgpDecryptDto";
    public static final String VALIDATION_FILE_INVALID_REQUEST = "Input field must be instance of ValidationFileNodeDto";
    public static final String GENERATE_PDF_INVALID_REQUEST = "Input field must be instance of GeneratePdfRequestDto";
    public static final String CREATE_FILE_INVALID_REQUEST = "Input field must be instance of CreateFileRequestDto";
    public static final String CREATE_FILE_NAME_MANDATORY = "File Name Cannot Null";
    public static final String CLOSE_FILE_MANDATORY = "Close File node must have Create File Node";
    public static final String WRITE_TO_FILE_INVALID_REQUEST = "Input field must be instance of WriteToFileRequestDto";
    public static final String FILE_TRANSFER_TYPE_MANDATORY = "FileTransferType is mandatory";
    public static final String FILE_TRANSFER_UPLOAD_INVALID_REQUEST = "Input field must be instance of FileTransferUploadRequestDto";
    public static final String MOVE_FILE_INVALID_REQUEST = "Input field must be instance of MoveFileRequestDto";
    public static final String CATCH_EXCEPTION_MUST_BE_AFTER_END_NODE = "Catch Exception node must be after end node";
    public static final String INPUT_FIELD_NAME_AND_FUNCTION_WEB_SERVICE_CLIENT_CANNOT_NULL = "Input Field Name and Construct Request Function Cannot null";
    public static final String INPUT_FIELD_NAME_AND_CUSTOM_DTO_CANNOT_NULL = "One of Input Field Name or Custom Dto Function must have value";
    public static final String GET_PROCESSFLOW_BEAN_QUALIFIER_NAME_CANNOT_NULL = "getProcessFlowBeanQualifierNameFunction must not be null";
    public static final String GET_PROCESSFLOW_CONTENT_DTO_CLASS_CANNOT_NULL = "getProcessFlowContentDtoClassFunction must not be null";
    public static final String FEIGN_CLIENT_FUNCTION_CANNOT_NULL = "feignClientFunction must not be null";
    public static final String CALL_REST_INVALID_REQUEST = "Input field must be not null and instance of CallRestRequestDto";
    public static final String CALL_REST_INVALID_HTTP_METHOD = "HttpMethod is not supported";
    public static final String REST_TEMPLATE_NOT_FOUND = "Rest template not found";
    public static final String LDAP_AUTHENTICATION_REQUEST_MANDATORY_ERROR = "Ldap Authentication Request Cannot Null";
    public static final String LDAP_AUTHENTICATION_SEARCH_BASE_MANDATORY_ERROR = "Ldap Authentication Search Base Cannot Null";
    public static final String LDAP_AUTHENTICATION_RESPONSE_FIELD_NAME_MANDATORY_ERROR = "Ldap Authentication Response Field Name Cannot Null";
    public static final String LDAP_AUTHENTICATION_FILTER_MANDATORY_ERROR = "Ldap Authentication Filter Cannot Null";
    public static final String LDAP_AUTHENTICATION_URL_MANDATORY_ERROR = "Ldap Authentication URL Cannot Null";
    public static final String LDAP_AUTHENTICATION_USER_MANDATORY_ERROR = "Ldap Authentication User Cannot Null";
    public static final String LDAP_AUTHENTICATION_PASSWORD_MANDATORY_ERROR = "Ldap Authentication Password Cannot Null";
    public static final String CREATE_PDF_INVALID_REQUEST = "Input field must be instance of CreatePdfRequestDto";
    public static final String CREATE_PDF_MANDATORY = "Create Pdf Node not exist";
    public static final String CREATE_PDF_MUST_CLOSE_FIRST_BEFORE_ANOTHER_CREATE_PDF = "Previous createPdf node must be closed first before calling another createPdf node";
    public static final String CREATE_PDF_LAYOUT_MUST_CLOSE_FIRST_BEFORE_ANOTHER_CREATE_PDF_LAYOUT = "Previous createPdfLayout node must be closed first before calling another createPdfLayout node";
    public static final String CLOSE_PDF_MANDATORY = "Close Pdf Node not exist";
    public static final String PROCESS_CHART_INVALID_REQUEST = "Input field must be instance of ChartResponseDto";
    public static final String APPEND_IMAGE_TO_PDF_INVALID_REQUEST = "Input field must be instance of AppendImageToPdfRequestDto";
    public static final String APPEND_LABEL_TO_PDF_INVALID_REQUEST = "Input field must be instance of AppendLabelToPdfRequestDto";
    public static final String APPEND_TABLE_TO_PDF_INVALID_REQUEST = "Input field must be instance of AppendTableToPdfRequestDto";
    public static final String PDF_TABLE_HEADER_IS_MANDATORY = "Table header is mandatory";

    public ProcessFlowConfigurationException(String message, Object... arguments) {
        super(message, arguments);
    }

    public ProcessFlowConfigurationException(String message, Throwable cause, Object... arguments) {
        super(message, cause, arguments);
    }
}
