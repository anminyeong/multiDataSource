package com.hwc.isl.common.utils;

/**
 * <pre>
 * Standard Log Message Format
 * </pre>
 * 
 * @author CHA
 * @since 2017. 2. 15.
 * @version
 */
public class LogMsgUtil
{
    /**
     * <pre>
     * Trace Log Format
     * </pre>
     * 
     * @param traceMsg
     *            출력메시지
     * @return 포맷팅된 메시지 ( TRACE :: 출력메시지 )
     */
    public static String traceFormat ( final String traceMsg )
    {
        final StringBuilder strBuilder = new StringBuilder ();
        strBuilder.append ( ":: TRACE :: " );
        strBuilder.append ( traceMsg );

        return strBuilder.toString ();
    }

    /**
     * <pre>
     * Debug Log Format
     * </pre>
     * 
     * @param debugMsg
     *            출력메시지
     * @return 포맷팅된 메시지( DEBUG :: 출력메시지 )
     */
    public static String debugFormat ( final String debugMsg )
    {
        final StringBuilder strBuilder = new StringBuilder ();
        strBuilder.append ( ":: DEBUG :: " );
        strBuilder.append ( debugMsg );

        return strBuilder.toString ();
    }

    /**
     * <pre>
     * Info Log Format
     * </pre>
     * 
     * @param infoMsg
     *            출력메시지
     * @return 포맷팅된 메시지( [ 출력메시지 ] )
     */
    public static String infoFormat ( final String infoMsg )
    {
        final StringBuilder strBuilder = new StringBuilder ();
        strBuilder.append ( "[ " );
        strBuilder.append ( infoMsg );
        strBuilder.append ( " ]" );

        return strBuilder.toString ();
    }

    /**
     * <pre>
     * Info Log Format
     * - 상위 Info Log 로 부터 들여쓰기 위한 Log
     * </pre>
     * 
     * @param infoMsg
     *            출력메시지
     * @return 포맷팅된 메시지( space space 출력메시지 ] )
     */
    public static String infoFormatDepth ( final String infoMsg )
    {
        final StringBuilder strBuilder = new StringBuilder ();
        strBuilder.append ( "  " );
        strBuilder.append ( infoMsg );

        return strBuilder.toString ();
    }

    /**
     * <pre>
     * Warn Log Format
     * </pre>
     * 
     * @param warnMsg
     *            출력메시지
     * @return 포맷팅된 메시지( [ 출력메시지 ] )
     */
    public static String warnFormat ( final String warnMsg )
    {
        final StringBuilder strBuilder = new StringBuilder ();
        strBuilder.append ( "[[ " );
        strBuilder.append ( ":: WARNING ::" );
        strBuilder.append ( warnMsg );
        strBuilder.append ( " ]]" );

        return strBuilder.toString ();
    }

    /**
     * <pre>
     * Error Log Format
     * </pre>
     * 
     * @param errorMsg
     *            에러메시지
     * @return 포맷팅된 메시지( ERROR Content :: 에러메시지 )
     */
    public static String errorFormat ( final String errorMsg )
    {
        final StringBuilder strBuilder = new StringBuilder ();
        strBuilder.append ( "ERROR Content :: " );
        strBuilder.append ( errorMsg );

        return strBuilder.toString ();
    }

    /**
     * <pre>
     * Error Log Format
     * - error code 포함
     * </pre>
     * 
     * @param errorCode
     *            에러코드
     * @param errorMsg
     *            에러메시지
     * @return 포맷팅된 메시지 ( ERROR[에러코드] Content :: 에러메시지 )
     */
    public static String errorFormat ( final String errorCode,
                                       final String errorMsg )
    {
        final StringBuilder strBuilder = new StringBuilder ();
        strBuilder.append ( "ERROR [ " );
        strBuilder.append ( errorCode );
        strBuilder.append ( " ] Content :: " );
        strBuilder.append ( errorMsg );

        return strBuilder.toString ();
    }

    /**
     * <pre>
     * Class 및 method 의 Trace 를 위한 메시지 생성
     * </pre>
     * 
     * @param clazz
     *            실행 class
     * @param methodName
     *            실행 method
     * @return 포맷팅된 메시지 ( [ class : class명 - method : 메소드명 ERROR!!] )
     */
    @SuppressWarnings ( "rawtypes" )
    public static String makeErrTraceMessage ( final Class clazz,
                                               final String methodName )
    {
        final StringBuilder errorBuilder = new StringBuilder ();
        errorBuilder.append ( " [ class : " );
        errorBuilder.append ( clazz.getSimpleName () );
        errorBuilder.append ( " - method : " );
        errorBuilder.append ( methodName + " ERROR!! ]" );

        return errorBuilder.toString ();
    }

}
