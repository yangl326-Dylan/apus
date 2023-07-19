package com.dylan326.tmp;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TTransportException;

import java.util.Arrays;

/**
 * Created by dylan on 2023/5/31.
 */
public class TestThrift {

    public static void main(String[] args) throws TException {
        Data tmpOld3field = new Data();
        tmpOld3field.setAppId((short) 1);
        tmpOld3field.setUid(13509);
        tmpOld3field.setUseAccess(false);


        TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();
        TSerializer serializer = new TSerializer(protocolFactory);
        byte[] tmpOld3fieldString = serializer.serialize(tmpOld3field);
        TDeserializer dSerializer = new TDeserializer(protocolFactory);

//        byte[] tmp = new byte[]{10, 0, 1, 0, 0, 0, 0, 0, 0, 52, -59, 6, 0, 2, 0, 1, 2, 0, 3, 0, 0};
        DataNew tmp2field = new DataNew();
        dSerializer.deserialize(tmp2field, tmpOld3fieldString);

        System.out.println(tmpOld3field); // 1
        System.out.println(tmp2field);// 2

        System.out.println(tmpOld3fieldString.length +":"+Arrays.toString(tmpOld3fieldString));// 3

        byte[] byteData2 = serializer.serialize(tmp2field);
        System.out.println(tmp2field);// 4
        System.out.println(byteData2.length+":"+Arrays.toString(byteData2));// 5

    }
}
