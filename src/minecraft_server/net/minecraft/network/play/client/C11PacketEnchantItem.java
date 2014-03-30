package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C11PacketEnchantItem extends Packet
{
    private int field_149541_a;
    private int field_149540_b;
    private static final String __OBFID = "CL_00001352";

    public void func_148833_a(INetHandlerPlayServer p_149538_1_)
    {
        p_149538_1_.func_147338_a(this);
    }

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer p_148837_1_) throws IOException
    {
        this.field_149541_a = p_148837_1_.readByte();
        this.field_149540_b = p_148837_1_.readByte();
    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public void writePacketData(PacketBuffer p_148840_1_) throws IOException
    {
        p_148840_1_.writeByte(this.field_149541_a);
        p_148840_1_.writeByte(this.field_149540_b);
    }

    /**
     * Returns a string formatted as comma separated [field]=[value] values. Used by Minecraft for logging purposes.
     */
    public String serialize()
    {
        return String.format("id=%d, button=%d", new Object[] {Integer.valueOf(this.field_149541_a), Integer.valueOf(this.field_149540_b)});
    }

    public int func_149539_c()
    {
        return this.field_149541_a;
    }

    public int func_149537_d()
    {
        return this.field_149540_b;
    }

    public void func_148833_a(INetHandler p_148833_1_)
    {
        this.func_148833_a((INetHandlerPlayServer)p_148833_1_);
    }
}